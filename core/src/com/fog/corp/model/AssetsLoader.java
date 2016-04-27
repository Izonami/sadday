package com.fog.corp.model;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.fog.corp.GameStart;
import com.fog.corp.veiw.AbstractScreen;
import com.uwsoft.editor.renderer.data.ProjectInfoVO;
import com.uwsoft.editor.renderer.data.SceneVO;
import com.uwsoft.editor.renderer.resources.IResourceLoader;

/**
 * Created by Izonami on 27.04.2016.
 */
public class AssetsLoader extends AbstractScreen implements IResourceLoader
{
    private TextureAtlas textureAtlas;

    public AssetsLoader(final GameStart app)
    {

    }

    @Override
    public void render(float delta)
    {

    }

    private void loadingAssets()
    {

    }

    @Override
    public void loadAtlasPack() {

    }

    @Override
    public void loadParticleEffects() {

    }

    @Override
    public void loadSpriteAnimations() {

    }

    @Override
    public void loadSpineAnimations() {

    }

    @Override
    public void loadFonts() {

    }

    @Override
    public void loadShaders() {

    }

    @Override
    public void loadSpriterAnimations() {

    }

    @Override
    public SceneVO loadSceneVO(String sceneName) {
        return null;
    }

    @Override
    public ProjectInfoVO loadProjectVO() {
        return null;
    }
}
