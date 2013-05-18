
package com.cyntain.Fm.block;


import java.util.Random;

import com.cyntain.Fm.lib.BlockIDs;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;




public class WorldGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.dimensionId) {
            case 1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case -1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);

        }
    }

    private void generateEnd(World world, Random random, int chunkX, int chunkZ) {

    }

    private void generateSurface(World world, Random random, int chunkX,
            int chunkZ) {

        for (int i = 0; i < 25; i++) {
            int xCord = chunkX + random.nextInt(16);
            int yCord = random.nextInt(72);
            int zCord = chunkZ + random.nextInt(16);

            (new WorldGenMinable(BlockIDs.COPPER_ORE_DEFAULT, 8)).generate(
                    world, random, xCord, yCord, zCord);
        }

        for (int i = 0; i < 25; i++) {
            int xCord = chunkX + random.nextInt(16);
            int yCord = random.nextInt(72);
            int zCord = chunkZ + random.nextInt(16);

            (new WorldGenMinable(BlockIDs.OSMIUM_ORE_DEFAULT, 8)).generate(
                    world, random, xCord, yCord, zCord);
        }

        for (int i = 0; i < 25; i++) {
            int xCord = chunkX + random.nextInt(16);
            int yCord = random.nextInt(72);
            int zCord = chunkZ + random.nextInt(16);

            (new WorldGenMinable(BlockIDs.BERYLLIUM_ORE_DEFAULT, 8)).generate(
                    world, random, xCord, yCord, zCord);
        }

        for (int i = 0; i < 15; i++) {
            int xCord = chunkX + random.nextInt(16);
            int yCord = random.nextInt(24);
            int zCord = chunkZ + random.nextInt(16);

            (new WorldGenMinable(BlockIDs.ZEOLITE_ORE_DEFAULT, 8)).generate(
                    world, random, xCord, yCord, zCord);
        }

    }

    private void generateNether(World world, Random random, int chunkX,
            int chunkZ) {

    }

}
