package no.hiof.tobiasb.oblig6mod.customItem;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import no.hiof.tobiasb.oblig6mod.Oblig6Mod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Oblig6Mod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD) // Her lages en egen creative-tab.
public class ModCreativeModeTabs {                                                      // Mye av dette er mal, se kilde for creative tab i rapport.
    public static CreativeModeTab OBLIG6_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) { // Denne forklarer at taben registreres, og at det skal være en ny stack
        OBLIG6_TAB = event.registerCreativeModeTab(new ResourceLocation(Oblig6Mod.MOD_ID, "oblig6_tab"), // med items. Ikonet er CREWMATE,
                builder -> builder.icon(() -> new ItemStack(ModItems.CREWMATE.get())).title(Component.translatable("creativemodetab.oblig6_tab"))); // og tittelen skal kunne oversettes.
    }           // Grunnet problemer med å kommentere i JSON, forklares det her. I resources/assets/oblig6mod/lang/en_us.json finnes det "default"-verdier
}               // til navn knyttet til modden. Det er ganske selvforklarende når en ser på det.
