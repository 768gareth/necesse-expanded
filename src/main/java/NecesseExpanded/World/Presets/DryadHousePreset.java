package NecesseExpanded.World.Presets;

import NecesseExpanded.Mobs.Friendly.Human.FriendlyDryadMob;
import necesse.level.maps.presets.Preset;

public class DryadHousePreset extends Preset
{
    public DryadHousePreset() 
    {
        super("eNrdVs1u2zAMfhU_gA-Sk_jnkNPWw04dugE7DDnIsmprdSxDUhYUw959FC3FP03WoUsuBRjGoj5SH0nJ8ueHuy93X7e_jrKyzZbSuBGybuy2iK1sxaePZvud5nFU6WdWPbZK6TiCYd8y2ZlaM2McLI6KOFI_ha61OnaLyR1Ggjg5ul5F6OL3OmKCLIKmr-KKgP5H2EVqxUXcdH4BfCn5LlblD8EtNobEEZPQELqGvg0tKlnXCTBlbq7ljdg_W1a6DtEkyWaNi6N1msTRXhnzbKzoe9nVxqpOwEy-BqxqK4Bb8F2tYGiObN9z1lXQTAt_EBIY7VnfCqsFoBIgUUrNm2GYFRC9VJ1h0hlgcrXeAAMgYGEp7YgcOnDLPPdW1aXoeAOmfGFKXLjcc0CSnBlYIychcdNLLS1nNVjTbOOte1UdWqZ9CdIs9XbeYOHyFGLWQK7jTPfCQkokXcMyB_3IuNCKP6FpMzOBY5qfCi4qhKQziNmztnWwZIQlDlf48RHnKSV-XOHJSvNQi0oLY1wjKV0HF9lV6gik3a7RoiqVejJhP7hjig0eqHhdhISGHAara5PHoiZLUBGUW3pQo22KRHfcRCMAa495YPJYqJl7GhwTenJJfSsWCicGv2LOGQtHLnltPG2ycHKRyFwmS7zIbKSdkZDYSZ3PyWs8j1PEGVWE0k0dJy3EEuV-i7_s4uiwi7WyzEo4abAJwIZCwsP0eWp05xGFzpFJkFXQZzEn91VAnmYHC5kDpnFWAbkQOgdMVyQXOFzKgv41IB3upPvh6HxoBdNbqw8idsfyo-BK34dTRc4R_U_B9yB5Z7Ibi_cw7sdbLJW8x-LhFXWzrYd3Md7i14qIXwhvdHUXGF7n-G67VR1vswtPL7drRXuzL70qk6F63L0K720j9DcJXyDbR9Ya8fsP8iGTcQ==");
        this.addMob("friendly_dryad", 5, 5, FriendlyDryadMob.class, (dryad) ->
        {
            dryad.setHome(dryad.getTileX(), dryad.getTileY());
        });
    }
}
