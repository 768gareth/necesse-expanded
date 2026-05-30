package NecesseExpanded.World.Presets;

import necesse.entity.mobs.friendly.human.humanShop.PawnBrokerHumanMob;
import necesse.level.maps.presets.Preset;

public class DesertHousePreset extends Preset
{
    public DesertHousePreset() 
    {
        super("eNrVVk2P2jAQ_Sv8gBwSe_Nx4bZ76GlX20o9VBwcx5AsIaaOKYeq_70z4yR1CF1YCRArDRbz_GY8zBsSv7w-fX36Nv-9rwpbziMWlKpalXaeBbaq1ZfHdv4jDmataAr0gxnLnNda3ajcVHK9rLU2wSzhbmNlxC9VI3lBKVyCCxpW8L_Pzanxu8wzDVt3fG8R6PxNSUs6hMFMVNDpaKRBQd3nDHLsRV3XorHKNMDizGPtq6bQe-RBWgkoapmmkGirrVWFFNLu2gdMDpCoN9YoZGS8Z4DMe2VixJIe2-JpDKF0BEEQ1uOSBrMsgXNWkLCRwmyVhR8Wp-6YomoaZazIsZ44ziYoZI-T0MEbXexqMbCTyMGypLbESVd6DueUcGoE2Ywqcq3XLW5zb5vSPnQAEkpVLxFLelKBXjp4EJAxCPi5q7DHxVYYWW5UYxEH2lKYVinTapNDYNqVUhjVtoo0S301QCjAwqwHd2YppDJartsN7PWyO9EHQ20GBxs8cugIt6D0nnsE-5eQXOo8iUJd8dyUdV3pYl0cVd4nInlpIUl8dzidArqSp3EHCwnulTnxBjtkeoV1S_aBTlCwl5t1UxN2f5U-OyCLwGgrbKWbA4188xWKJrsREaLJFidj3hfmZeNeuB_IjoHRGGHjXX6sKp8zVMj6SqJ-PeCEk6qG-kP3Gng-NtA3Nhqu8M7Ntev19HTdwKLP0C58mD4qqc09jNg9GB-9Gt7v2X3M2T0YO_m3xGvHNQeNblFZ_3LEywZdtejKdrFHYJSdVQm_xnNtaODVpo57r0l-UtMLjsfZnI82TdZKmGdbKvO9gsvkfCnqVv35C65vynU=");
        this.addMob("pawnbrokerhuman", 4, 4, PawnBrokerHumanMob.class, (pwn) ->
        {
            pwn.setHome(pwn.getTileX(), pwn.getTileY());
        });
        
    }
}
