package com.magistuarmory.client.proxy;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.renderer.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.renderer.model.entity.*;
import com.magistuarmory.client.renderer.tileentity.HeraldyItemStackRenderer;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.proxy.IProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IDyeableArmorItem;
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
    public <A extends BipedModel<?>> A getGothicModel(EquipmentSlotType armorSlot)
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
    public static Item.Properties setHeraldyItemStackRenderer(Item.Properties prop)
    {
        return prop.setISTER(() -> HeraldyItemStackRenderer::new);
    }

    @OnlyIn(Dist.CLIENT)
    public void onLateInit()
    {
        for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().renderers.values())
        {
            if (renderer instanceof ArmorStandRenderer)
            {
                ArmorStandRenderer renderer0 = (ArmorStandRenderer) renderer;
				renderer0.addLayer(new ArmorDecorationLayer<>(renderer0, new SurcoatModel<>(), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
            }
			if (renderer instanceof VillagerRenderer)
            {
                VillagerRenderer renderer0 = (VillagerRenderer) renderer;
				renderer0.addLayer(new ArmorDecorationLayer(renderer0, new SurcoatModel<>(), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
			}
            if (renderer instanceof BipedRenderer<?, ?>)
            {
                BipedRenderer<?, ?> renderer0 = (BipedRenderer<?, ?>) renderer;
                renderer0.addLayer(new ArmorDecorationLayer(renderer0, new SurcoatModel<>(), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
            }
            if (renderer instanceof HorseRenderer)
            {
                HorseRenderer renderer0 = (HorseRenderer) renderer;
                renderer0.addLayer(new HorseArmorDecorationLayer(renderer0, new CaparisonModel<>(), new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/caparison.png"), "caparison"));
            }
        }
        for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values())
        {
			if (renderer instanceof PlayerRenderer)
			{
                PlayerRenderer renderer0 = (PlayerRenderer) renderer;
				renderer0.addLayer(new ArmorDecorationLayer<>(renderer0, new SurcoatModel<>(), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
			}
		}

        for (Item item : ModItems.dyeableItems)
		{
			Minecraft.getInstance().getItemColors().register((p_92708_, p_92709_) ->
			{
				return p_92709_ > 0 ? -1 : ((IDyeableArmorItem) p_92708_.getItem()).getColor(p_92708_);
			}, item);
		}
    }
}
