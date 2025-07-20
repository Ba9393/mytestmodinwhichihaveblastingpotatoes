// ModBiomes.java
package idk.ohio.idkwtfidoin;

//import net.fabricmc.fabric.api.biome.v1.FabricBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
//import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import static idk.ohio.idkwtfidoin.TemplateMod.MOD_ID;

public class ModBiomes {
//    public static final RegistryKey<Biome> CONDENSED_KEY = RegistryKey.of(
//            RegistryKeys.BIOME, new Identifier(MOD_ID, "condensed_dirt_biome")
//    );

 //   public static void registerBiomes() {
//        Biome condensed = createCondensedBiome();
//        Registry.register(BuiltinRegistries.BIOME, CONDENSED_KEY.getValue(), condensed);

//        FabricBiomes.addSpawnBiome(condensed);
//        FabricBiomes.addStrongholdBiome(condensed);
//        FabricBiomes.addNetherFortressBiome(condensed);
//        FabricBiomes.addEndCityBiome(condensed);

//        FabricBiomes.addBiomeModification(
//                registryKey -> registryKey.equals(RegistryKeys.BIOME),
//                entries -> entries.add(CONDENSED_KEY)
//        );
//    }

//    public static Biome createCondensedBiome() {
//        return new Biome.Builder()
//                .precipitation(Biome.Precipitation.NONE)
//                .temperature(0.8f).downfall(0f)
//                .effects(new BiomeEffects.Builder()
//                        .skyColor(0x8b00ff).fogColor(0x3a0055)
//                        .waterColor(0x440088).waterFogColor(0x330055)
//                        .build())
//                .spawnSettings(new SpawnSettings.Builder().build())
//                .generationSettings(new GenerationSettings.Builder()
//                        .surfaceBuilder(
 //                               SurfaceBuilder.DEFAULT,
//                                new TernarySurfaceConfig(
//                                  ModBlocks.CONDENSED_DIRT.getDefaultState(),
//                                        ModBlocks.CONDENSED_DIRT.getDefaultState(),
//                                        Blocks.STONE.getDefaultState())
//                        )
//                        .build()
//                ).build();
//    }
}
