package top.ourisland.messagehider;

import net.fabricmc.api.ModInitializer;

public final class MessageHider implements ModInitializer {

    public static final String MOD_ID = "messagehider";

    @Override
    public void onInitialize() {
        // No runtime registration is required.
        // Public chat hiding is implemented entirely with a server-side mixin.
    }

}
