package com.magistuarmory.client.proxy;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.entity.layer.HorseArmorDecorationLayer;
import com.magistuarmory.client.renderer.entity.layer.ArmorDecorationLayer;
import com.magistuarmory.client.renderer.model.entity.*;
import com.magistuarmory.client.renderer.tileentity.HeraldyItemStackRenderer;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.item.IHasModelProperty;
import com.magistuarmory.proxy.IProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy implements IProxy
{
    private static final BipedModel<LivingEntity> armetModel = new ArmetModel();
    private static final BipedModel<LivingEntity> stechhelmModel = new StechhelmModel();
    private static final BipedModel<LivingEntity> salletModel = new SalletModel();
    private static final BipedModel<LivingEntity> maximilianHelmetModel = new MaximilianHelmetModel();
    private static final BipedModel<LivingEntity> kettlehatModel = new KettlehatModel();
    private static final BipedModel<LivingEntity> barbuteModel = new BarbuteModel();
    private static final BipedModel<LivingEntity> bascinetModel = new BascinetModel();
    private static final BipedModel<LivingEntity> grandBascinetModel = new GrandBascinetModel();

    private static final BipedModel<LivingEntity> wingedHussarChestplateModel = new WingedHussarChestplateModel();
    private static final BipedModel<LivingEntity> armorModel = new BipedModel<>(1.0F);
    private static final BipedModel<LivingEntity> armorLeggingsModel = new BipedModel<>(0.5F);

    public static void doClientStuff(FMLClientSetupEvent ev)
    {
        for (ModItems.ShieldsSupply routine : ModItems.shieldsSupply)
        {
            routine.get().forEach(item -> ev.enqueueWork(((IHasModelProperty) item.get())::registerModelProperty));
        }

        for (ModItems.ItemsSupply<SwordItem> routine : ModItems.weaponsSupply)
        {
            routine.get().forEach(item -> ev.enqueueWork(((IHasModelProperty) item.get())::registerModelProperty));
        }

        ev.enqueueWork(((IHasModelProperty) ModItems.LONGBOW.get())::registerModelProperty);
        ev.enqueueWork(((IHasModelProperty) ModItems.HEAVY_CROSSBOW.get())::registerModelProperty);
        ev.enqueueWork(((IHasModelProperty) ModItems.NOBLE_SWORD.get())::registerModelProperty);
        ev.enqueueWork(((IHasModelProperty) ModItems.MESSER_SWORD.get())::registerModelProperty);
    }
    
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
    public <A extends BipedModel<?>> A getKastenbrustModel(EquipmentSlotType armorSlot)
    {
        return (armorSlot == EquipmentSlotType.HEAD) ? (A)this.grandBascinetModel : ((armorSlot == EquipmentSlotType.LEGS) ? (A)this.armorLeggingsModel : (A)this.armorModel);
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
            if (renderer instanceof LivingRenderer) 
            {
                LivingRenderer<?, ?> renderer0 = (LivingRenderer<?, ?>) renderer;
                if (renderer0.getModel() instanceof BipedModel) 
                {
                    renderer0.addLayer(new ArmorDecorationLayer(renderer0, new SurcoatModel<>(), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
                }
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

        for (RegistryObject<? extends Item> itemRegistry : ModItems.dyeableItems)
		{
			Minecraft.getInstance().getItemColors().register((p_92708_, p_92709_) ->
                    p_92709_ > 0 ? -1 : ((IDyeableArmorItem) p_92708_.getItem()).getColor(p_92708_), itemRegistry.get());
		}
    }
}
