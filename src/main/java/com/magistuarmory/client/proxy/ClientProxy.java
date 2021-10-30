package com.magistuarmory.client.proxy;

import com.magistuarmory.client.renderer.model.entity.*;
import com.magistuarmory.client.renderer.model.item.AbstractShieldModel;
import com.magistuarmory.client.renderer.tileentity.HeraldyItemStackRenderer;
import com.magistuarmory.item.MedievalShieldItem;
import com.magistuarmory.proxy.IProxy;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ShieldItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy implements IProxy {
    private final ArmetModel armetModel = new ArmetModel();
    private final StechhelmModel stechhelmModel = new StechhelmModel();
    private final SalletModel salletModel = new SalletModel();
    private final MaximilianHelmetModel maximilianHelmetModel = new MaximilianHelmetModel();
    private final KettlehatModel kettlehatModel = new KettlehatModel();
    private final BarbuteModel barbuteModel = new BarbuteModel();
    private final BascinetModel bascinetModel = new BascinetModel();
    private final WingedHussarChestplateModel wingedHussarChestplateModel = new WingedHussarChestplateModel();
    private final BipedModel<LivingEntity> armorModel = new BipedModel<>(1.0F);
    private final BipedModel<LivingEntity> armorLeggingsModel = new BipedModel<>(0.5F);

    public void setup(IEventBus modEventBus, IEventBus forgeEventBus)
    {
        modEventBus.addListener(this::clientSetup);
    }

    private void clientSetup(FMLClientSetupEvent event)
    {}

    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getKnightModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.HEAD) ? (A)this.armetModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
    }

    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getJoustingModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.HEAD) ? (A)this.stechhelmModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
    }

    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getGohicModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.HEAD) ? (A)this.salletModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
    }

    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getMaximilianModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.HEAD) ? (A)this.maximilianHelmetModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
    }

    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getChainmailModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel;
    }
  
    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getPlatemailModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.HEAD) ? (A)this.kettlehatModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
    }

    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getHalfarmorModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.HEAD) ? (A)this.barbuteModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
    }

    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getXIVCenturyKnightModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.HEAD) ? (A)this.bascinetModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
    }

    @OnlyIn(Dist.CLIENT)
    public <A extends BipedModel<?>> A getWingedHussarModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.CHEST) ? (A)this.wingedHussarChestplateModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
    }
	
    @OnlyIn(Dist.CLIENT)
    public Item.Properties setHeraldyItemStackRenderer(Item.Properties prop)
    {
        return prop.setISTER(() -> HeraldyItemStackRenderer::new);
    }
}
