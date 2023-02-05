package me.liangcha.claycollection.item;

import me.liangcha.claycollection.ClayCollection;
import me.liangcha.claycollection.tab.RegistryTab;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ClayCollection.MOD_ID);
    public static final RegistryObject<Item> card = ITEMS.register("card", () ->
            new Item(new Item.Properties().tab(RegistryTab.cardTab)));
    public static final RegistryObject<Item> businessCard = ITEMS.register("business_card", () -> new BusinessCard());
    public static void registry(IEventBus iEventBus) {
        ITEMS.register(iEventBus);
    }
}