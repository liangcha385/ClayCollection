package me.liangcha.claycollection.tab;

import me.liangcha.claycollection.item.RegistryItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class CardTab extends ItemGroup {
    public CardTab() {
        super("cardtab");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(RegistryItem.card.get());
    }
}
