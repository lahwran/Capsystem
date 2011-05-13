Minecraft client/server capability protocol
===========================================

The capability system is a protocol for tracking what the client and server are capable of, so that extensions to both know when the other side will understand their custom messages.

This document describes capsystem protocol version 0.

Capability types
----------------
Capabilities are strings that represent something a client or server can or cannot do. The first character of a capability string represents the capability type; a "+" symbol indicates it was added since vanilla, a "-" means it was removed since vanilla, "=" means it's a vanilla feature, and "v" means it's the protocol version (which is special to the protocol version capability).

A colon in a capability represents arguments; for instance, '+customskin:v0.1'. this is to communicate extra information that is important to the capability system that will not change during the connection.

For example, a client could have:
```
v0 +nether +customskin +babycreeper -sponge
```

initialization
--------------

Initialization is performed entirely via chat messages. It should as early as possible, at least before the MOTDs and preferably before chunks are sent (required if any capabilities affect chunkloading).

- client << server: '§0§0§0§0' followed by a hex, colorcode-masked representation of the capsystem protocol version. for this protocol version, the message is '§0§0§0§0§0' (the trigger, plus another 'black' colorcode, as this is protocol version 0 and version 0 is encoded to '§0'.)
- client >> server: '/@caps v[clientcapversion] [capabilities]' - capabilities are space seperated, but the message may not exceed 100 characters. if adding a capability would exceed the 100 characters, another message is sent. this is repeated until there are no capabilities left to send. for example '/@caps v0 +whatever +whatelse -removedcapability'
- client >> server: '/@cap done' - indicates that the client is done sending capabilities.
- client << server: '§0§0§0§0[capabilities]' - capabilities are space seperated, message wraps to 100 characters same as the client-to-server capability listing.

Both ends are required to store the other's capabilities, so that this communication only needs to happen once. The any time the server sends the first packet of this communication, the handshaking occurs; However it is strongly recommended to initialize once, early on connection.
[at this point both ends may proceed to do whatever they need to based on sent capabilities]