package no.hiof.tobiasb.oblig6mod.customItem;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import no.hiof.tobiasb.oblig6mod.Oblig6Mod;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = // Her lages et register for nye items
            DeferredRegister.create(ForgeRegistries.ITEMS, Oblig6Mod.MOD_ID);

    public static final RegistryObject<Item> CREWMATE = ITEMS.register("crewmate", // Dette er to items som legges til i ITEMS-registeret
            () -> new Item(new Item.Properties()));                                      // recipes under resources/data viser at man kan smelte en CREWMATE for
                                                                                         // å få en AMOGUS. Koden er hentet fra vanille minecraft, og modifisert.
    public static final RegistryObject<Item> AMOGUS = ITEMS.register("amogus",
            () -> new Item(new Item.Properties()));                                      // Item.Properties gir itemet de riktige funksjonalitetene for å
                                                                                         // kunne fungere som det skal i spillet.
                                                                                         // In-game-navn for disse finnes i en_us.json i resources/assets/oblig6mod/lang
                                                                                         // sammen med en teit, norsk oversetning.
    public static void register(IEventBus eventbus) { // Som alltid er det en IEventBus nederst som sender info videre til Oblig6Mod, for å kunne laste det inn.
        ITEMS.register(eventbus);
    }
}           // JSON gjør dette fort veldig rotete når det kommer til kommentarer. I assets/models/item finner vi to små JSON-filer som forklarer hva slags item
            // dette er, og hvilket bilde (texture) den skal hente fra assets/models/textures/item:.
