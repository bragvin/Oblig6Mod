package no.hiof.tobiasb.oblig6mod.customItem;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import no.hiof.tobiasb.oblig6mod.Oblig6Mod;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Oblig6Mod.MOD_ID);

   // public static final RegistryObject<Item> AMONGUS = ITEMS.register("Crewmate",
          //  () -> new

    public static void register(IEventBus eventbus) {
        ITEMS.register(eventbus);
    }
}
