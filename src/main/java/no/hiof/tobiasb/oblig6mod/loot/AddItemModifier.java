package no.hiof.tobiasb.oblig6mod.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier { // Denne codec-en legger til en modifier, som gjør at ItemStacks osv kan moddes. (Forge)
    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(() // Denne går inn i Forge-registre og henter frem codec-er som trengs
            -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ForgeRegistries.ITEMS.getCodec() // Her skal AddItemModifier hentes
            .fieldOf("item").forGetter(m -> m.item)).apply(inst, AddItemModifier::new)));
    private final Item item;

    protected AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item; // Denne "item" er den som er lagt til av meg i resources/data/oblig6mod/loot_modifiers.
    }                     // I global_loot_modifiers i data/forge/loot_modifiers refereres denne oppskriften.

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if(context.getRandom().nextFloat() >= 0.4f) { // Denne henter en liste ItemStack som er satt til at skal droppe ved et event
            generatedLoot.add(new ItemStack(item));   // f.eks at man får rotten flesh ved å drepe en Zombie, og legger til det itemet vi legger til
        }                                             // I akkurat denne vil det nye itemet droppe 60% av gangene oak_leaves blir ødelagt.
                                                      // nextFloat() er større enn 0.4 i 60% av tilfellene, da denne kan være alt mellom 1 og 0.
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() { // Her opprettes / hentes denne codec-en som brukes i ModLootModifiers.java.
        return CODEC.get();                               // den henter CODEC fra øverste metode, som ligger i Forge.
    }
}