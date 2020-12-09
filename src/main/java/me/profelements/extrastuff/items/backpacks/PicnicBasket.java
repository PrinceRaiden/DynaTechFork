package me.profelements.extrastuff.items.backpacks;

import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.SlimefunBackpack;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class PicnicBasket extends SlimefunBackpack {

    private final Set<Material> defaultBlacklist = new HashSet<>();

    private final ItemSetting<Set<String>> blacklistedMaterials = new ItemSetting<>("blacklistedMaterials", ToStringSet(getDefaultBlacklist()));

    public PicnicBasket(int size, Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(size, category, item, recipeType, recipe);

        /*Maybe use Material.getMaterial() and send a set of strings*/

        addItemSetting(blacklistedMaterials);
    }

    @Override
    public boolean isItemAllowed(ItemStack item, SlimefunItem itemAsSlimefunItem) {
        return item.getType().isEdible() && !blacklistedMaterials.getValue().contains(item.getType().toString()); //!blacklistedMaterials.getValue().contains(item.getType());
    }

    private Set<Material> getDefaultBlacklist() {
        defaultBlacklist.add(Material.PUFFERFISH);
        defaultBlacklist.add(Material.POISONOUS_POTATO);
        defaultBlacklist.add(Material.SPIDER_EYE);
        defaultBlacklist.add(Material.CHORUS_FRUIT);
        defaultBlacklist.add(Material.ENCHANTED_GOLDEN_APPLE);
        defaultBlacklist.add(Material.GOLDEN_APPLE);
        defaultBlacklist.add(Material.ROTTEN_FLESH);

        //Returns Stuff, maybe will figure this out later.
        defaultBlacklist.add(Material.SUSPICIOUS_STEW);
        defaultBlacklist.add(Material.MUSHROOM_STEW);
        defaultBlacklist.add(Material.RABBIT_STEW);
        defaultBlacklist.add(Material.HONEY_BOTTLE);

        return defaultBlacklist;
    }

    private Set<String> ToStringSet(Set<Material> mats) {
        Set<String> materials = new HashSet<>();

        for (Material mat : mats) {
            materials.add(mat.toString());
        }

        return materials;
    }

}
