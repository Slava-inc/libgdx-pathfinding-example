package com.kiriost.game.screen;

import com.badlogic.gdx.graphics.Camera;
import com.kiriost.game.input.ModifierKey;

/**
 * Created by kiriost on 14/04/16.
 */
public class CameraManager {
    float limitX, limitY;
    private Camera camera;
    private int cameraTranslateModifier = 1;

    public CameraManager(Camera camera, float limitX, float limitY) {
        this.camera = camera;
        this.limitX = limitX;
        this.limitY = limitY;
    }

    public void update(float delta) {
        // Camera movements
        if (ModifierKey.L_SHIFT)
            cameraTranslateModifier = 4;
        else
            cameraTranslateModifier = 1;

        if (ModifierKey.LEFT && camera.position.x >= 0) {
            camera.translate(-8f * cameraTranslateModifier, 0f, 0f);
        } else if (ModifierKey.RIGHT && camera.position.x <= limitX) {
            camera.translate(8f * cameraTranslateModifier, 0f, 0f);
        }
        if (ModifierKey.DOWN && camera.position.y >= 0) {
            camera.translate(0f, -8f * cameraTranslateModifier, 0f);
        } else if (ModifierKey.UP && camera.position.y <= limitY) {
            camera.translate(0f, 8f * cameraTranslateModifier, 0f);
        }
    }
}
