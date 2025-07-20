package idk.ohio.idkwtfidoin;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.chunk.WorldChunk;

import java.util.Random;

public class DirtReplacer {
//    private static final Random random = new Random();

//    public static void register() {
//        ServerWorldEvents.LOAD.register((minecraftServer, world) -> {
            // Loop through all chunks after world loads
//            world.getChunkManager().setChunkLoadCallback((chunkX, chunkZ) -> {
//                WorldChunk chunk = world.getChunk(chunkX, chunkZ);
//                ChunkPos pos = chunk.getPos();

//                for (int x = 0; x < 16; x++) {
//                    for (int z = 0; z < 16; z++) {
//                        for (int y = world.getBottomY(); y < world.getTopY(); y++) {
//                            BlockPos blockPos = new BlockPos(pos.getStartX() + x, y, pos.getStartZ() + z);
//                            if (world.getBlockState(blockPos).isOf(Blocks.DIRT)) {
//                                if (random.nextFloat() < 0.1f) { // 10% chance
//                                    world.setBlockState(blockPos, ModBlocks.CONDENSED_DIRT.getDefaultState(), 3);
//                                }
//                            }
//                        }
//                    }
//                }
//            });
//        });
//    }
}
