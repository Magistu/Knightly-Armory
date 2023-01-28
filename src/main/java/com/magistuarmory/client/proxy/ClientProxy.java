package com.magistuarmory.client.proxy;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.client.renderer.entity.layer.*;
import com.magistuarmory.client.renderer.model.*;
import com.magistuarmory.client.renderer.model.item.*;
import com.magistuarmory.client.renderer.tileentity.HeraldryItemStackRenderer;
import com.magistuarmory.init.ModItems;
import com.magistuarmory.item.IHasModelProperty;
import com.magistuarmory.proxy.IProxy;

import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

public class ClientProxy implements IProxy
{
	private static final HumanoidModel<LivingEntity> armetModel = new HumanoidModel<>(ArmetModel.createModel());
	private static final HumanoidModel<LivingEntity> stechhelmModel = new HumanoidModel<>(StechhelmModel.createModel());
	private static final HumanoidModel<LivingEntity> salletModel = new HumanoidModel<>(SalletModel.createModel());
	private static final HumanoidModel<LivingEntity> maximilianHelmetModel = new HumanoidModel<>(MaximilianHelmetModel.createModel());
	private static final HumanoidModel<LivingEntity> kettlehatModel = new HumanoidModel<>(KettlehatModel.createModel());
	private static final HumanoidModel<LivingEntity> barbuteModel = new HumanoidModel<>(BarbuteModel.createModel());
	private static final HumanoidModel<LivingEntity> bascinetModel = new HumanoidModel<>(BascinetModel.createModel());
	private static final HumanoidModel<LivingEntity> grandBascinetModel = new HumanoidModel<>(GrandBascinetModel.createModel());
	
	private static final HumanoidModel<LivingEntity> wingedHussarChestplateModel = new HumanoidModel<>(WingedHussarChestplateModel.createModel());
	private static final HumanoidModel<LivingEntity> armorModel = new HumanoidModel<>(LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(1.0F), 0.0F), 64, 32).bakeRoot());
	private static final HumanoidModel<LivingEntity> armorLeggingsModel = new HumanoidModel<>(LayerDefinition.create(HumanoidModel.createMesh(new CubeDeformation(0.5F), 0.0F), 64, 32).bakeRoot());

	public static final HeaterShieldModel heaterShieldModel = new HeaterShieldModel(HeaterShieldModel.createLayer().bakeRoot());
	public static final PaviseModel paveseModel = new PaviseModel(PaviseModel.createLayer().bakeRoot());
	public static final RoundShieldModel roundShieldModel = new RoundShieldModel(RoundShieldModel.createLayer().bakeRoot());
	public static final EllipticalShieldModel ellipticalShieldModel = new EllipticalShieldModel(EllipticalShieldModel.createLayer().bakeRoot());
	public static final TartscheModel tartscheModel = new TartscheModel(TartscheModel.createLayer().bakeRoot());
	public static final RondacheModel rondacheModel = new RondacheModel(RondacheModel.createLayer().bakeRoot());
	public static final KiteShieldModel kiteShieldModel = new KiteShieldModel(KiteShieldModel.createLayer().bakeRoot());

	public static void doClientStuff(FMLClientSetupEvent ev)
	{
		for (ModItems.ShieldsSupply routine : ModItems.shieldsSupply)
        {
            routine.get().forEach(item -> ev.enqueueWork(((IHasModelProperty) item.get())::registerModelProperty));
        }

        for (ModItems.ItemsSupply<SwordItem> routine : ModItems.weaponsWithModelPropertySupply)
        {
            routine.get().forEach(item -> ev.enqueueWork(((IHasModelProperty) item.get())::registerModelProperty));
        }

		ev.enqueueWork(((IHasModelProperty) ModItems.LONGBOW.get())::registerModelProperty);
		ev.enqueueWork(((IHasModelProperty) ModItems.HEAVY_CROSSBOW.get())::registerModelProperty);
		ev.enqueueWork(((IHasModelProperty) ModItems.NOBLE_SWORD.get())::registerModelProperty);
		ev.enqueueWork(((IHasModelProperty) ModItems.MESSER_SWORD.get())::registerModelProperty);

		ev.enqueueWork(((IHasModelProperty) ModItems.CORRUPTEDROUNDSHIELD.get())::registerModelProperty);
	}

	@Override
	public void setup(IEventBus modEventBus, IEventBus forgeEventBus)
	{
		//Mod Event Bus Listeners
		modEventBus.addListener(this::clientSetup);
	}

	private void clientSetup(final FMLClientSetupEvent ev) {}
	
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getKnightModel(EquipmentSlot armorSlot) {
		return (A) (armorSlot == EquipmentSlot.HEAD ? armetModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}
	
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getJoustingModel(EquipmentSlot armorSlot) {
		return (A) (armorSlot == EquipmentSlot.HEAD ? stechhelmModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}
	
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getGothicModel(EquipmentSlot armorSlot) {
		return (A) (armorSlot == EquipmentSlot.HEAD ? salletModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}
	
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getMaximilianModel(EquipmentSlot armorSlot) {
		return (A) (armorSlot == EquipmentSlot.HEAD ? maximilianHelmetModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}
	
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getArmorModel(EquipmentSlot armorSlot) {
		return (A) (armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}
	
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getPlatemailModel(EquipmentSlot armorSlot) {
		return (A) (armorSlot == EquipmentSlot.HEAD ? kettlehatModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}
	
	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getHalfarmorModel(EquipmentSlot armorSlot) 
	{
		return (A) (armorSlot == EquipmentSlot.HEAD ? barbuteModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}

    @OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getXIVCenturyKnightModel(EquipmentSlot armorSlot) {
		return (A) (armorSlot == EquipmentSlot.HEAD ? bascinetModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}

	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getWingedHussarModel(EquipmentSlot armorSlot) {
        return (A) (armorSlot == EquipmentSlot.CHEST ? wingedHussarChestplateModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
    }

	@OnlyIn(Dist.CLIENT)
	public <A extends HumanoidModel<?>> A getKastenbrustModel(EquipmentSlot armorSlot) {
		return (A) (armorSlot == EquipmentSlot.HEAD ? grandBascinetModel : armorSlot == EquipmentSlot.LEGS ? armorLeggingsModel : armorModel);
	}

	@OnlyIn(Dist.CLIENT)
	public static BlockEntityWithoutLevelRenderer getHeraldryItemStackRenderer(String id, String name)
	{
		return new HeraldryItemStackRenderer(id, name);
	}

	public static void onLateInit(final EntityRenderersEvent.AddLayers ev)
	{
		for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().renderers.values())
		{
			if (renderer instanceof LivingEntityRenderer renderer0 && renderer0.getModel() instanceof HumanoidModel)
			{
				renderer0.addLayer(new ArmorDecorationLayer<>(renderer0, new SurcoatModel<>(SurcoatModel.createLayer().bakeRoot()), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
			}
			if (renderer instanceof HorseRenderer renderer0)
			{
				renderer0.addLayer(new HorseArmorDecorationLayer(renderer0, new CaparisonModel<>(CaparisonModel.createLayer().bakeRoot()), new ResourceLocation(KnightlyArmory.ID, "textures/entity/horse/armor/caparison.png"), "caparison"));
			}
		}
		for (EntityRenderer<?> renderer : Minecraft.getInstance().getEntityRenderDispatcher().getSkinMap().values())
		{
			if (renderer instanceof PlayerRenderer renderer0)
			{
				renderer0.addLayer(new ArmorDecorationLayer<>(renderer0, new SurcoatModel<>(SurcoatModel.createLayer().bakeRoot()), new ResourceLocation(KnightlyArmory.ID, "textures/models/armor/surcoat.png"), "surcoat"));
			}
		}

		for (RegistryObject<? extends Item> itemRegistry : ModItems.dyeableItems)
		{
			Minecraft.getInstance().getItemColors().register((p_92708_, p_92709_) ->
					p_92709_ > 0 ? -1 : ((DyeableLeatherItem) p_92708_.getItem()).getColor(p_92708_), itemRegistry.get());
		}
	}
}
