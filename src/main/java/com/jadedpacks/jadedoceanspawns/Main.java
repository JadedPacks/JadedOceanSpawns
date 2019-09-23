package com.jadedpacks.jadedoceanspawns;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;

import java.util.Arrays;

@Mod(modid = "jadedoceanspawns", name = "JadedOceanSpawns", version = "@VERSION@")
public class Main {
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		for(BiomeDictionary.Type type : BiomeDictionary.Type.values()) {
			for(BiomeGenBase biome : BiomeDictionary.getBiomesForType(type)) {
				if(biome == null) {
					continue;
				}
				biome.enableRain = true;
				biome.getSpawnableList(EnumCreatureType.creature).addAll(Arrays.asList(
					new SpawnListEntry(EntitySheep.class, 8, 1, 4),
					new SpawnListEntry(EntityCow.class, 8, 1, 4),
					new SpawnListEntry(EntityChicken.class, 8, 1, 4),
					new SpawnListEntry(EntityPig.class, 4, 1, 4)
				));
				biome.getSpawnableList(EnumCreatureType.monster).addAll(Arrays.asList(
					new SpawnListEntry(EntitySkeleton.class, 8, 1, 2),
					new SpawnListEntry(EntityZombie.class, 4, 1, 2),
					new SpawnListEntry(EntitySpider.class, 6, 1, 2),
					new SpawnListEntry(EntityWitch.class, 2, 1, 2),
					new SpawnListEntry(EntityCreeper.class, 2, 1, 2),
					new SpawnListEntry(EntityEnderman.class, 3, 1, 2)
				));
				biome.getSpawnableList(EnumCreatureType.waterCreature).add(new SpawnListEntry(EntitySquid.class, 8, 1, 2));
				try {
					biome.getSpawnableList(EnumCreatureType.monster).add(new SpawnListEntry(Class.forName("thaumcraft.common.entities.monster.EntityBrainyZombie"), 4, 1, 4));
				} catch(Exception ignored) {
				}
				try {
					biome.getSpawnableList(EnumCreatureType.monster).add(new SpawnListEntry(Class.forName("ganymedes01.headcrumbs.entity.EntityHuman"), 2, 1, 2));
				} catch(Exception ignored) {
				}
			}
		}
	}
}
