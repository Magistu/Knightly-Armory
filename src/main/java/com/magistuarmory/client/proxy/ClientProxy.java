package com.magistuarmory.client.proxy;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.entity.layer.RemovingHatLayer;
import com.magistuarmory.client.renderer.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.renderer.model.entity.*;
import com.magistuarmory.client.renderer.tileentity.HeraldyItemStackRenderer;
import com.magistuarmory.proxy.IProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy implements IProxy
{
    private static final ArmetModel armetModel = new ArmetModel();
    private static final StechhelmModel stechhelmModel = new StechhelmModel();
    private static final SalletModel salletModel = new SalletModel();
    private static final MaximilianHelmetModel maximilianHelmetModel = new MaximilianHelmetModel();
    private static final KettlehatModel kettlehatModel = new KettlehatModel();
    private static final BarbuteModel barbuteModel = new BarbuteModel();
    private static final BascinetModel bascinetModel = new BascinetModel();
    private static final WingedHussarChestplateModel wingedHussarChestplateModel = new WingedHussarChestplateModel();

    private static final BipedModel<LivingEntity> armorModel = new BipedModel<>(1.0F);
    private static final BipedModel<LivingEntity> armorLeggingsModel = new BipedModel<>(0.5F);

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

    @Override
    public void onLateInit(final IEventBus modbus)
    {
//        for (EntityRenderer<?> entityRenderer : Minecraft.getInstance().getEntityRenderDispatcher().renderers.values())
//        {
//            if (entityRenderer instanceof BipedRenderer)
//            {
//                BipedRenderer<?, ?> bipedRenderer = (BipedRenderer<?, ?>) entityRenderer;
//                bipedRenderer.addLayer(new RemovingHatLayer(bipedRenderer));
//                bipedRenderer.addLayer(new ArmorDecorationLayer(bipedRenderer, new SurcoatModel(), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png")));
//            }
//        }
//        for (PlayerRenderer playerRenderer : Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values()) {
//            playerRenderer.addLayer(new RemovingHatLayer(playerRenderer));
//            playerRenderer.addLayer(new ArmorDecorationLayer(playerRenderer, new SurcoatModel(), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png")));
//        }
    }
}
