Capsystem
=========

Important: Neither capsystem or commsystem are quite ready for production use,
as the interface and possibly the protocol may still change.


What is in this repo
--------------------

- Informal protocol specifications of capsystem and commsystem
- implementation for the minecraft client as a modloader plugin
- implementation for the bukkit java server api as a plugin


What capsystem and commsystem are
---------------------------------

Capsystem is a protocol for determining what a client and server can do. It is
basically an attempt to make capability negotiation very standard - instead of
each addon coming up with it's own system, which means lots and lots of chatter
on startup, it can simply use this, which means one protocol which is standard
across any server that uses it.

Commsystem v0 is a simple communication protocol, to avoid having to modify or 
add packets. In the future, I hope to make commsystem capable of using custom
packets, but for now it is focused on being easy to use. Note that I am not
happy with the current protocol for commsystem, and I will likely make it more
like worldeditcui's protocol.


Why this is needed
------------------

If you are running a large minecraft server that you wish to be self-supporting
(eg, you're paying for it with money made via it), then you need it to be easy,
fun, and friendly. The "classic modloadermp" system where incapable clients are
kicked is obviously not acceptable in this case, as players with incapable 
clients (aka, everyone who's never been there before) never get to see how
exciting/fun/scary/selling_point_here your server is.

This is why I am creating capsystem. I run just such a server and I would like
to write additions that can be had on the client too, but at the same time I
do not wish to prevent vanilla clients from at least connecting and seeing my
spawn area.


Use case example
----------------

The example I often give is the addition of new blocks. If blocks are added
that the vanilla client does not recognize, it will choke and die. However, if
you first check if a client is capable of dealing with your blocks, you can run
a filter on your packet51-packet53 to ensure incapable clients only see the
nearest vanilla block; For instance, you could replace special fences with
vanilla fence, or your colored glass with cloth.

Obviously the gameplay will be dumbed down. It would be preferred if the server
warned a client any time they interacted with an added block. 


When *not* to filter
--------------------

There are times when such compatibility is so gameplay-breaking, it's just not
acceptable. Flan brought up the good example of SDK's guns on a deathmatch
server: if you show the guns as sticks to incapable clients, people will wonder
why they are being killed with sticks!

On the other hand, if guns are used rarely on your server, then it would
probably be acceptable to simply warn players when they see a player carrying
a filtered gun.


Note one the name
-----------------

yes, the name sucks. I'll probably change it before I start using it. Capsystem
has a very technical ring to it, and there is the whole thing about it sounding
cheesy. Those might even be connected.


Note on this readme
-------------------

Excuse the length, I was having fun typing.
