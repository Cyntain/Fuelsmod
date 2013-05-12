
package com.cyntain.Fm.Block;


import com.cyntain.Fm.lib.Strings;

import net.minecraft.block.material.Material;




public class BlockWorkshopTable extends BlockFm {

    public BlockWorkshopTable(int id, Material material) {

        super(id, material);
        setUnlocalizedName(Strings.WORKSHOPTABLE_BLOCK);
        setHardness(5F);

    }

}
