package idk.ohio.idkwtfidoin;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Heightmap;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class TemplateMod implements ModInitializer {
	public static final String MOD_ID = "template-mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		ModItems.initialize();
		ModBlocks.init();
//		DirtReplacer.register(); // 👈 Add this line

		final Item SUSPICIOUS_SUBSTANCE = ModItems.register("suspicious_substance", (settings) -> new Item(settings.maxCount(4096)) {
			@Override
			public ActionResult use(World world, PlayerEntity user, Hand hand) {
				ItemStack stack = user.getStackInHand(hand);

				if (!world.isClient) {
					Vec3d look = user.getRotationVec(1.0f);

					FireballEntity fireball = new FireballEntity(
							world,
							user,
							look,
							20
					);

					fireball.updatePosition(user.getX(), user.getEyeY(), user.getZ());
					world.spawnEntity(fireball);
				}

				return ActionResult.SUCCESS;
			}
		}, new Item.Settings());

		final Block CONDENSED_DIRT = ModBlocks.register(
				"condensed_dirt",
				Block::new,
				AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS),
				true
		);

		// Get the event for modifying entries in the ingredients group.
		// And register an event handler that adds our suspicious item to the ingredients group.
		// ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
		// 		.register((itemGroup) -> itemGroup.add(SUSPICIOUS_SUBSTANCE));

		final RegistryKey<ItemGroup> MAIN_GROUP_KEY = RegistryKey.of(
				RegistryKeys.ITEM_GROUP, Identifier.of(MOD_ID, "idk")
		);

		final ItemGroup MAIN_GROUP = Registry.register(
				Registries.ITEM_GROUP,
				MAIN_GROUP_KEY,
				FabricItemGroup.builder()
						.icon(() -> new ItemStack(SUSPICIOUS_SUBSTANCE))
						.displayName(Text.translatable("itemGroup." + MOD_ID + ".idk"))
						.build()
		);

		// Add items to the custom group
		ItemGroupEvents.modifyEntriesEvent(MAIN_GROUP_KEY).register(entries -> {
			entries.add(SUSPICIOUS_SUBSTANCE);
			entries.add(CONDENSED_DIRT.asItem());
		});

//		ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
//			if (!(world instanceof ServerWorld)) return;
//
//			ChunkPos pos = chunk.getPos();
//			Random rand = new Random();
//
//			for (int x = 0; x < 16; x++) {
//				for (int z = 0; z < 16; z++) {
//					int topY = world.getTopY(Heightmap.Type.WORLD_SURFACE, pos.getStartX() + x, pos.getStartZ() + z);
//					for (int y = world.getBottomY(); y <= topY; y++) {	BlockPos blockPos = new BlockPos(pos.getStartX() + x, y, pos.getStartZ() + z);
//						if (chunk.getBlockState(blockPos).isOf(Blocks.DIRT)) {
//							if (rand.nextFloat() < 0.1f) {
//								chunk.setBlockState(blockPos, CONDENSED_DIRT.getDefaultState(), 2);
//							}
//						}
//					}
//				}
//			}
//		});

	}
}
