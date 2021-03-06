package holiday.item;

import holiday.HolidayMod;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemIceCreamBall extends Item {

	private Icon[] icons;
	
	public ItemIceCreamBall(int id) {
		super(id);
		
		setCreativeTab(HolidayMod.tabFood);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return Items.iceCreamNames[stack.getItemDamage()] + "IceCreamBall";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register) {
		icons = new Icon[Items.iceCreamNames.length];
		
		for(int i = 0; i < icons.length; i++) {
			icons[i] = register.registerIcon("holiday" + ":" + Items.iceCreamNames[i] + "IceCreamBall");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(int id, CreativeTabs tab, List list) {
		for(int i = 0; i < Items.iceCreamNames.length; i++) {
			ItemStack stack = new ItemStack(id, 1, i);
			list.add(stack);
		}
	}

}
