package com.magistuarmory.config;

import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.io.FileUtils;

import com.magistuarmory.KnightlyArmory;

import net.minecraft.client.Minecraft;


public class EpicFightConfig
{
	
//	private static final Path CONFIGDIR_PATH = Minecraft.getMinecraft().mcDataDir.toPath().resolve("config");
//
//	public void addEpicFightConfig() throws IOException
//	{
//		String EFConfig;
//
//		if (CONFIGDIR_PATH.resolve("epicfight.cfg").toFile().exists())
//		{
//			EFConfig = FileUtils.readFileToString(CONFIGDIR_PATH.resolve("epicfight.cfg").toFile(), "UTF-8");
//		}
//		else
//		{
//			EFConfig = "# Configuration file\ncustom {\n    custom_weaponry {\n        sample_weapon1 {\n            D:armor_negation=0.0\n            D:impact=0.5\n            I:max_strikes=1\n            S:registry_name=modid:registryname\n            # Valid values:\n            # AXE\n            # FIST\n            # HOE\n            # PICKAXE\n            # SHOVEL\n            # SWORD\n            # SPEAR\n            # GREATSWORD\n            # KATANA\n            S:weapon_type=SWORD\n        }\n        sample_weapon2 {\n            S:registry_name=modid:registryname\n            # Valid values:\n            # AXE\n            # FIST\n            # HOE\n            # PICKAXE\n            # SHOVEL\n            # SWORD\n            # SPEAR\n            # GREATSWORD\n            # KATANA\n            S:weapon_type=SWORD\n            onehand {\n                D:armor_negation=0.0\n                D:impact=0.5\n                I:max_strikes=1\n            }\n            twohand {\n                D:armor_negation=0.0\n                D:impact=0.5\n                I:max_strikes=1\n            }\n        }\n    }\n    custom_armor {\n        sample_armor {\n            S:registry_name=modid:registryname\n            D:stun_armor=0.0\n            D:weight=0.0\n        }\n    }\n}";
//		}
//
//		if (!EFConfig.contains(KnightlyArmory.ID))
//		{
//			EpicConfigBuilder epicConfigBuilder = new EpicConfigBuilder();
//			String KWConfig = epicConfigBuilder.generateWeaponConfig();
//			String KAConfig = epicConfigBuilder.generateArmorConfig();
//
//			String EFConfigModified = EFConfig.replace("    custom_weaponry {", KWConfig).replace("    custom_armor {", KAConfig);
//
//			FileUtils.writeStringToFile(CONFIGDIR_PATH.resolve("knightly-armory_epicfight.cfg").toFile(), EFConfigModified, "UTF-8");
//
//			if (CONFIGDIR_PATH.resolve("epicfight.cfg").toFile().exists())
//			{
//				FileUtils.copyFile(CONFIGDIR_PATH.resolve("knightly-armory_epicfight.cfg").toFile(), CONFIGDIR_PATH.resolve("epicfight.cfg").toFile());
//			}
//		}
//	}



	private static final Path CONFIGDIR_PATH = Minecraft.getMinecraft().mcDataDir.toPath().resolve("config");

    public void addEpicFightConfig() throws IOException
    {
        String NewEFConfig = "";
        EpicConfigBuilder epicConfigBuilder = new EpicConfigBuilder();
        String KWConfig = epicConfigBuilder.generateWeaponConfig();
        String KAConfig = epicConfigBuilder.generateArmorConfig();

        if (CONFIGDIR_PATH.resolve("epicfight.cfg").toFile().exists() && FileUtils.readFileToString(CONFIGDIR_PATH.resolve("epicfight.cfg").toFile(), "UTF-8").contains("custom_weaponry {"))
        {
            String EFConfig = FileUtils.readFileToString(CONFIGDIR_PATH.resolve("epicfight.cfg").toFile(), "UTF-8");
            if (EFConfig.contains("magistuarmory"))
            {
                boolean flag = false;
                for (String line : EFConfig.split("\n"))
                {
                    if (line.contains("custom_weaponry.") && contains(line, epicConfigBuilder.weapons))
                    {
                        flag = true;
                        continue;
                    }
                    if (flag)
                    {
                        if (line.contains("            ") || line.contains("\t\t\t") || line.contains("}"))
                        {
                            continue;
                        }
                        flag = false;
                    }
                    NewEFConfig = NewEFConfig + line + "\n";
                    continue;
                }
            }
            else
            {
                NewEFConfig = EFConfig;
            }
        }
        else
        {
			NewEFConfig = "# Configuration file\ncustom {\n    custom_weaponry {\n        sample_weapon1 {\n            D:armor_negation=0.0\n            D:impact=0.5\n            I:max_strikes=1\n            S:registry_name=modid:registryname\n            # Valid values:\n            # AXE\n            # FIST\n            # HOE\n            # PICKAXE\n            # SHOVEL\n            # SWORD\n            # SPEAR\n            # GREATSWORD\n            # KATANA\n            S:weapon_type=SWORD\n        }\n        sample_weapon2 {\n            S:registry_name=modid:registryname\n            # Valid values:\n            # AXE\n            # FIST\n            # HOE\n            # PICKAXE\n            # SHOVEL\n            # SWORD\n            # SPEAR\n            # GREATSWORD\n            # KATANA\n            S:weapon_type=SWORD\n            onehand {\n                D:armor_negation=0.0\n                D:impact=0.5\n                I:max_strikes=1\n            }\n            twohand {\n                D:armor_negation=0.0\n                D:impact=0.5\n                I:max_strikes=1\n            }\n        }\n    }\n    custom_armor {\n        sample_armor {\n            S:registry_name=modid:registryname\n            D:stun_armor=0.0\n            D:weight=0.0\n        }\n    }\n}";
        }
        String EFConfigModified = NewEFConfig.replace("custom_weaponry {", KWConfig).replace("custom_armory {", KAConfig);
        FileUtils.writeStringToFile(CONFIGDIR_PATH.resolve("knightly-armory_epicfight.cfg").toFile(), EFConfigModified, "UTF-8");
    }

    private boolean contains(String line, EpicConfigBuilder.Weapon[] weapons)
    {
        for (EpicConfigBuilder.Weapon weapon : weapons)
        {
            if (line.contains(weapon.getName()))
            {
                return true;
            }
        }
        return false;
    }
}
