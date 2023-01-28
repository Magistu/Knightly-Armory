package com.magistuarmory.config;

import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.io.FileUtils;

import com.magistuarmory.KnightlyArmory;
import com.magistuarmory.config.EpicConfigBuilder.Weapon;

import net.minecraftforge.fml.loading.FMLPaths;

public class EpicFightConfig {
	
	private static final Path CONFIGDIR_PATH = FMLPaths.CONFIGDIR.get();
	
	public void addEpicFightConfig() throws IOException
	{
		String NewEFConfig = "";
		EpicConfigBuilder epicConfigBuilder = new EpicConfigBuilder();
		String KWConfig = epicConfigBuilder.generateWeaponConfig();
		String KAConfig = epicConfigBuilder.generateArmorConfig();
		
		if (CONFIGDIR_PATH.resolve("epicfight.toml").toFile().exists() && FileUtils.readFileToString(CONFIGDIR_PATH.resolve("epicfight.toml").toFile(), "UTF-8").contains("[custom_weaponry]"))
		{
			String EFConfig = FileUtils.readFileToString(CONFIGDIR_PATH.resolve("epicfight.toml").toFile(), "UTF-8");
			
			if (EFConfig.contains("magistuarmory"))
			{
				boolean flag = false;
				for (String line : EFConfig.split("\n"))
				{
					if (line.contains("[custom_weaponry.") && contains(line, epicConfigBuilder.weapons))
					{
						flag = true;
						continue;
					}
					if (flag)
					{
						if (line.contains("        ") || line.contains("\t\t") || line.contains("    \t") || line.contains("\t    "))
						{
							continue;
						}
						else
						{
							flag = false;
						}
					}
					NewEFConfig += line + "\n";
				}
			}
			else
			{
				NewEFConfig = EFConfig;
			}
		}
		else
		{
			NewEFConfig = "\n[custom_entity]\n	[custom_entity.sample]\n		type_name = \"modid:type_name\"\n		impact = 0.5\n		max_strikes = 1\n		armor_negation = 0.0\n		ai_type = \"ZOMBIE\"\n		texture_location = \"modid:texture_location\"\n[custom_weaponry]\n	[custom_weaponry.sample]\n		armor_ignorance = 0.0\n		hit_at_once = 1\n		impact = 0.5\n		#Allowed Values: AXE, FIST, HOE, PICKAXE, SHOVEL, SWORD, SPEAR, GREATSWORD, KATANA, TACHI, KNUCKLE, LONGSWORD, DAGGER, BOW, CROSSBOW\n		weapon_type = \"SWORD\"\n		registry_name = \"modid:registryname\"\n[custom_armor]\n	[custom_armor.sample]\n		stunArmor = 0.0\n		weight = 0.0\n		registry_name = \"modid:registryname\"";
		}
		
		
		
		String EFConfigModified = NewEFConfig.replace("[custom_weaponry]", KWConfig).replace("[custom_armory]", KAConfig);
		
		FileUtils.writeStringToFile(CONFIGDIR_PATH.resolve("knightly-armory_epicfight.toml").toFile(), EFConfigModified, "UTF-8");
		
	}

	private boolean contains(String line, Weapon[] weapons) 
	{
		for (Weapon weapon : weapons)
		{
			if (line.contains(weapon.getName()))
			{
				return true;
			}
		}
		return false;
	}
}
