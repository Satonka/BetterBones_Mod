package huter.betterbones.main.entities.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import huter.betterbones.main.handlers.GrinderRecipies;
import huter.betterbones.main.items.ModItems;
import huter.betterbones.main.lib.Constants;
import net.minecraft.block.BlockFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class MeatGrinderEntity extends TileEntity implements IInventory{

	public ItemStack[] inv;
	private String field_145958_o;
	private short grindTime;
	public int cranks;
	public boolean canGrind;
	
	
	public MeatGrinderEntity(){
		inv = new ItemStack[9];
		cranks = 0;
	}
	
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		if (this.inv[slot] != null)
        {
            ItemStack itemstack;

            if (this.inv[slot].stackSize <= amt)
            {
                itemstack = this.inv[slot];
                this.inv[slot] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.inv[slot].splitStack(amt);

                if (this.inv[slot].stackSize == 0)
                {
                    this.inv[slot] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (this.inv[slot] != null)
        {
            ItemStack itemstack = this.inv[slot];
            this.inv[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		this.inv[slot] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        } 
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.field_145958_o : "container.furnace";
	}
	
	public void func_145951_a(String p_145951_1_)
    {
        this.field_145958_o = p_145951_1_;
    }

	@Override
	public boolean hasCustomInventoryName() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : p_70300_1_.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	
	public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        tag.setInteger("cranks", cranks);
        tag.setBoolean("canGrind", this.canGrind());
    }

    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        cranks = tag.getInteger("cranks");
        canGrind = tag.getBoolean("canGrind");
    }

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack item) {
		if(slot == 1 || slot == 2){
			return false;
		}else{
			return true;
		}
	}

	@SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int p_145953_1_)
    {
        return this.grindTime * p_145953_1_ / 200;
    }
	
	public void updateEntity(){
		if(cranks == 5){
			this.grindItem();
			cranks = 0;
		}
    }
	
	public boolean canGrind()
    {
        if (this.inv[0] == null)
        {
        	canGrind = false;
            return false;
        }
        else
        {
        	if(GrinderRecipies.getResult(this.inv[0]) != null){
	        	ItemStack[] itemstack = GrinderRecipies.getResult(this.inv[0]); 
	            if (itemstack == null) return false;
	            if (this.inv[1] == null) return true;
	            if (!this.inv[1].isItemEqual(itemstack[0]) || !this.inv[2].isItemEqual(itemstack[1])) return false;
	            int result = inv[1].stackSize + itemstack[0].stackSize;
	            canGrind = result <= getInventoryStackLimit() && result <= this.inv[2].getMaxStackSize();
	            return result <= getInventoryStackLimit() && result <= this.inv[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
	        }else{
	        	return false;
	        }
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void grindItem()
    {
        if (this.canGrind() || canGrind)
        {
        	if(GrinderRecipies.getResult(this.inv[0]) != null){
	            ItemStack[] itemstack = GrinderRecipies.getResult(this.inv[0]);
	
	            if (this.inv[1] == null && this.inv[2] == null){
	                this.inv[1] = itemstack[0].copy();
	                this.inv[2] = itemstack[1].copy();
	            }else if (this.inv[1].getItem() == itemstack[0].getItem() && this.inv[2].getItem() == itemstack[1].getItem()){
	                this.inv[1].stackSize += itemstack[0].stackSize;
	                this.inv[2].stackSize += itemstack[1].stackSize;// Forge BugFix: Results may have multiple items
	            }
	
	            --this.inv[0].stackSize;
	
	            if (this.inv[0].stackSize <= 0)
	            {
	                this.inv[0] = null;
	            }
        	}
        }
    }
    
    public void crank(){
    	cranks++;
    }
	
}
