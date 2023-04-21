package no.hiof.tobiasb.oblig6mod.loot;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import no.hiof.tobiasb.oblig6mod.Oblig6Mod;

public class ModLootModifiers {                                                                              // IGlobalLootModifier er Minecrafts klasse for akkurat denne funksjonen. (Se AddItemModifier.java)
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFER_SERIALIZERS =    // Dette er måten man legger til en override på loot drops.
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Oblig6Mod.MOD_ID);// Her lager den et nytt register for slike items.

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM = // Her lages det en RegistryObject<> for å kunne legge til items i liste
            LOOT_MODIFER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);

    public static void register(IEventBus bus) { // Denne sender info videre som blir plukket opp i Oblig6Mod, som laster det inn i spillet.
        LOOT_MODIFER_SERIALIZERS.register(bus);
    }
}
