package me.liangcha.claycollection.item;

import me.liangcha.claycollection.tab.RegistryTab;
import me.liangcha.claycollection.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class BusinessCard extends Item {
    public BusinessCard() {
        super(new Properties().tab(RegistryTab.cardTab).durability(20));
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, World world, List<ITextComponent> list, ITooltipFlag iTooltipFlag) {
        list.add(new TranslationTextComponent("item.business_card.lore1"));
        if (Screen.hasShiftDown()){
            list.add(new TranslationTextComponent("item.business_card.lore2"));
        }else {
            list.add(new TranslationTextComponent("shift.lore"));
        }
    }

    @Override
    public ActionResultType useOn(ItemUseContext itemUseContext) {
        if (itemUseContext.getLevel().isClientSide()){
            BlockPos posClicked = itemUseContext.getClickedPos();
            PlayerEntity player = itemUseContext.getPlayer();
            boolean foundBlock = false;
            for (int i = 0; i <= posClicked.getY() + 64; i++){
                Block block = itemUseContext.getLevel().getBlockState(posClicked.below(i)).getBlock();
                if (isValuableBlock(block)){
                    outputValuableCoordinates(posClicked.below(i), player, block);
                    foundBlock = true;
                    break;
                }
            }
            if (!foundBlock) {
                player.sendMessage(new TranslationTextComponent("business_card.notfound"), player.getUUID());
            }
        }
        itemUseContext.getItemInHand().hurtAndBreak(1, itemUseContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));
        return super.useOn(itemUseContext);
    }

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block){
        player.sendMessage(new TranslationTextComponent("business_card.found"), player.getUUID());
        ITextComponent ITextComponent = new TranslationTextComponent("(" + blockPos.getX() + " " + blockPos.getY() + " " + blockPos.getZ() + ")" + block.getRegistryName().toString());
        player.sendMessage(ITextComponent, player.getUUID());
    }

    private boolean isValuableBlock(Block block){
        return ModTags.Blocks.dowsingRadValuables.contains(block);
    }
}
