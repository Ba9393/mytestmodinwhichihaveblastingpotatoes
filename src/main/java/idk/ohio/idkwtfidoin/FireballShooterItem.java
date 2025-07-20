package idk.ohio.idkwtfidoin;

import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireballShooterItem extends Item {

    public FireballShooterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient) {
            Vec3d look = user.getRotationVec(1.0f);

            FireballEntity fireball = new FireballEntity(
                    world,
                    user,
                    new Vec3d(look.x, look.y, look.z),
                    1 // explosion power, 1 is default Ghast fireball power
            );

            fireball.setPosition(user.getX(), user.getEyeY(), user.getZ());
            world.spawnEntity(fireball);
        }

        return ActionResult.SUCCESS;
    }
}
