package no.hiof.tobiasb.oblig6mod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import no.hiof.tobiasb.oblig6mod.customItem.ModCreativeModeTabs;
import no.hiof.tobiasb.oblig6mod.customItem.ModItems;
import no.hiof.tobiasb.oblig6mod.loot.ModLootModifiers;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Oblig6Mod.MOD_ID)
public class Oblig6Mod {
    public static final String MOD_ID = "oblig6mod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Oblig6Mod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus); //Denne kaller på ModItems, som gjør at custom items lastes inn med moden.

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        ModLootModifiers.register(modEventBus); //Denne kaller på ModLootModifiers, som gjør at loot modifieren lastes inn med moden.

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) { // Denne metoden henter Creative Taben i ModCreativeModeTabs, og legger den til i menyen.
        if (event.getTab() == ModCreativeModeTabs.OBLIG6_TAB) { // Den sier at hvis taben = (taben vi laget), hent disse items:
            event.accept(ModItems.CREWMATE);
            event.accept(ModItems.AMOGUS);
        }

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
