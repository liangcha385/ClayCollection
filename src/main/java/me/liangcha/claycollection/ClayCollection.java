package me.liangcha.claycollection;

import me.liangcha.claycollection.block.RegistryBlock;
import me.liangcha.claycollection.item.RegistryItem;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ClayCollection.MOD_ID)
public class ClayCollection {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "claycollection";

    public ClayCollection() {
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RegistryItem.registry(iEventBus);
        RegistryBlock.registry(iEventBus);
        iEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
