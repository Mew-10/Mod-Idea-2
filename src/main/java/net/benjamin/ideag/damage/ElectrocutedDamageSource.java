package net.benjamin.ideag.damage;

import net.minecraft.world.damagesource.DamageSource;

public class ElectrocutedDamageSource extends DamageSource {
    public static final DamageSource ELECTROCUTED = ((ElectrocutedDamageSource) new ElectrocutedDamageSource("electrocuted_to_death").bypassArmor());

    protected ElectrocutedDamageSource(String name) {
        super(name);
    }
}
