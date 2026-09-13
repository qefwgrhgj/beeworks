package com.qefwgrhgj.beeworks.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Bee;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Bee.class)
public class BeeMixin {
    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void noGravityOnLoad(CompoundTag tag, CallbackInfo ci) {
        if (!tag.contains("NoGravity")) {
            ((Bee) (Object) this).setNoGravity(true);
        }
    }

    @Inject(method = "getBreedOffspring(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/AgeableMob;)Lnet/minecraft/world/entity/animal/Bee;", at = @At("RETURN"))
    private void noGravityOnBreed(ServerLevel level, AgeableMob otherParent, CallbackInfoReturnable<Bee> cir) {
        Bee child = cir.getReturnValue();
        if (child != null) {
            child.setNoGravity(true);
        }
    }
}
