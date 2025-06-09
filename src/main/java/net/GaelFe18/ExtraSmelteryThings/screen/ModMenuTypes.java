package net.GaelFe18.ExtraSmelteryThings.screen;

import net.GaelFe18.ExtraSmelteryThings.ExtraSmelteryThings;
import net.GaelFe18.ExtraSmelteryThings.screen.custom.BasicAlloyerBlockMenu;
import net.GaelFe18.ExtraSmelteryThings.screen.custom.BasicFoundryBlockMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, ExtraSmelteryThings.MOD_ID);

    public static final RegistryObject<MenuType<BasicFoundryBlockMenu>> BASIC_FOUNDRY_BLOCK_MENU =
            MENUS.register("basic_foundry_block_menu", () -> IForgeMenuType.create(BasicFoundryBlockMenu::new));

    public static final RegistryObject<MenuType<BasicAlloyerBlockMenu>> BASIC_ALLOYER_BLOCK_MENU =
            MENUS.register("basic_alloyer_block_menu", () -> IForgeMenuType.create(BasicAlloyerBlockMenu::new));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}