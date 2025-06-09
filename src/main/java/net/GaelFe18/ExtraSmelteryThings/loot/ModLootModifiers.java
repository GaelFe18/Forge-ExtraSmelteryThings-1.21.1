package net.GaelFe18.ExtraSmelteryThings.loot;

import com.mojang.serialization.MapCodec;
import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, ExtraSmelteryThings.MOD_ID);

    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> SET_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("set_item", () -> SetItemModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }

}
