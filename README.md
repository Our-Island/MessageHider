# MessageHider

A **Fabric 26.1.2 server-side mod**.

Features:

* It does **not prevent** players from sending public chat messages.
* Public chat messages still go through the normal server-side sending flow.
* However, they are **silently hidden** before the server broadcasts them to clients.
* As a result, **no player can see any public chat message sent by any player**.
* It does **not affect private messages or targeted commands**, such as `/msg`, `/tell`, or `/w`.
* It does **not modify client-side behavior**; all logic is handled entirely during the server-side chat broadcast
  stage.

## Implementation

Implemented via a Mixin injection into the following Mojang-mapped method:

* `net.minecraft.server.players.PlayerList#broadcastChatMessage(PlayerChatMessage, ServerPlayer, ChatType.Bound)`

This overload handles the broadcast path for **normal player public chat**.

After injection, the original public chat broadcast is cancelled directly, which means:

* Players can send public chat messages without errors.
* The server does not broadcast those public chat messages to any client.
* All players silently do not see public chat.
* Targeted commands like `/msg` do not use this public chat broadcast overload, so they are unaffected.

## Build

Requires **Java 25**.

```bash
./gradlew build
```

The build output will be located in:

```text
build/libs/
```
