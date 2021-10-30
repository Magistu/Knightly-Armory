package com.magistuarmory.config;

import java.io.IOException;
import java.nio.file.Path;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.commons.io.FileUtils;

public class EpicFightConfig
{
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
            NewEFConfig = "\n[custom_entity]\n\t[custom_entity.sample]\n\t\ttype_name = \"modid:type_name\"\n\t\timpact = 0.5\n\t\tmax_strikes = 1\n\t\tarmor_negation = 0.0\n\t\tai_type = \"ZOMBIE\"\n\t\ttexture_location = \"modid:texture_location\"\n[custom_weaponry]\n\t[custom_weaponry.sample]\n\t\tarmor_ignorance = 0.0\n\t\thit_at_once = 1\n\t\timpact = 0.5\n\t\t#Allowed Values: AXE, FIST, HOE, PICKAXE, SHOVEL, SWORD, SPEAR, GREATSWORD, KATANA, TACHI, KNUCKLE, LONGSWORD, DAGGER, BOW, CROSSBOW\n\t\tweapon_type = \"SWORD\"\n\t\tregistry_name = \"modid:registryname\"\n[custom_armor]\n\t[custom_armor.sample]\n\t\tstunArmor = 0.0\n\t\tweight = 0.0\n\t\tregistry_name = \"modid:registryname\"";
        }
        String EFConfigModified = NewEFConfig.replace("[custom_weaponry]", KWConfig).replace("[custom_armory]", KAConfig);
        FileUtils.writeStringToFile(CONFIGDIR_PATH.resolve("knightly-armory_epicfight.toml").toFile(), EFConfigModified, "UTF-8");
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
