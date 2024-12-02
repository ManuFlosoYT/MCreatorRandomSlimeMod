
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.manufloso.randomslimemod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.manufloso.randomslimemod.item.SlimeItem;
import net.manufloso.randomslimemod.item.FlingerItem;
import net.manufloso.randomslimemod.RandomslimemodMod;

public class RandomslimemodModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RandomslimemodMod.MODID);
	public static final RegistryObject<Item> FLINGER = REGISTRY.register("flinger", () -> new FlingerItem());
	public static final RegistryObject<Item> SLIME_BOOTS = REGISTRY.register("slime_boots", () -> new SlimeItem.Boots());
	// Start of user code block custom items
	// End of user code block custom items
}
