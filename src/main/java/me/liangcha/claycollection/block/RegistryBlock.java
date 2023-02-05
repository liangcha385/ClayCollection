package me.liangcha.claycollection.block;

import me.liangcha.claycollection.ClayCollection;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ClayCollection.MOD_ID);

    public static void registry(IEventBus iEventBus) {
        BLOCKS.register(iEventBus);
    }
}