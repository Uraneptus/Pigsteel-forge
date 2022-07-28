package com.uraneptus.pigsteel.other;

import com.google.gson.JsonObject;
import com.uraneptus.pigsteel.PigsteelMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import net.minecraftforge.fml.ModList;

import net.minecraftforge.common.crafting.conditions.ICondition.IContext;

public class QuarkRecipeConditionFlag implements ICondition {

    private final ResourceLocation location;
    private final String flag;

    public QuarkRecipeConditionFlag(ResourceLocation location, String flag) {
        this.location = location;
        this.flag = flag;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test(IContext context) {
       if (PigsteelMod.QUARK_FLAG) {
           JsonObject jsonObject = new JsonObject();
           jsonObject.addProperty("type", "quark:flag");
           jsonObject.addProperty("flag", this.flag);
           return CraftingHelper.getCondition(jsonObject).test(context);
       }
       return false;
    }

    public static class Serializer implements IConditionSerializer<QuarkRecipeConditionFlag> {

        private final ResourceLocation location;

        public Serializer() {
            this.location = PigsteelMod.modPrefix("quark_flag");
        }

        @Override
        public void write(JsonObject json, QuarkRecipeConditionFlag value) {
            json.addProperty("flag", value.flag);
        }

        @Override
        public QuarkRecipeConditionFlag read(JsonObject json) {
            return new QuarkRecipeConditionFlag(this.location, json.getAsJsonPrimitive("flag").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
