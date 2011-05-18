Communication system
====================

This protocol describes a system for communicating arbitrary data. This version, version 0, uses chat entirely, but future versions may be able to transparently switch to a special packet.

The capability for this version of commsystem is "+comm:v0".

Message format
--------------

Messages start with the ID of the addon (plugin or mod) sending the message. The ID is a 4 char string, preferably as random as possible. It must cause an error to attempt to send a message with an ID that is more or less than 4 characters. The ID is immediately followed by the fields.

The fields are separated by the character '×'. Each field is prefixed by a character representing the data type. 

If the total length of a message would go above 100 characters, it is ended with the field separator '×'. Then another message is sent where the first field begins with '×', indicating it is a continuation. This can be repeated as many times as needed. 

Server to client messages are marked with the magic number '§0§0'. All server to client messages match the regex '^§0§0.*$'. 

Client to server messages are marked with the server command '/@comm '. all client to server messages match '^/@comm .*$'.

Data types
----------

Data types required by this version of commsystem are:

- 'b': binary, encoded as base64
- 't': plaintext (may not contain "×")
- 'i': integer, sent as plaintext
- 'j': integer, sent as base64 
- 'f': floatingpoint, sent as plaintext
- 'g': floatingpoint, sent as base64
- 'b': boolean, anything other than '0' is true

note: i/j and f/g should be indistinguishable to the addon calling commsystem and should be chosen by the commsystem as needed. 'i' and 'f' are for debugging purposes.
TODO: wrapping assumes ordered messages
TODO: unlimited wrapping is DOS attack vector