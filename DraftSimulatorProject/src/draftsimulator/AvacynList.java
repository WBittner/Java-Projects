/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draftsimulator;

import java.util.ArrayList;

/**
 *
 * @author William
 */
public class AvacynList {
    
    ArrayList<Card> pack;
    ArrayList<String> sPack;
    static String[] mythics = {"Avacyn Angel of Hope-8w","Bonfire of the Damned-1r","Bruna Light of Alabaster-6wu","Craterhoof Behemoth-8g","Descent into Madness-5b",
                        "Entreat the Angels-3w","Gisela Blade of Goldnight-7rw","Griselbrand-8b","Malignus-5r","Misthollow Griffin-4u","Primal Surge-10g","Sigarda Host of Herons-5gw",
                        "Tamiyo the Moon Sage-5u","Temporal Mastery-7u","Tibalt the Fiend Blooded-2r"};
    static String[] rares = {"Alchemists Refuge-0c","Angel of Glorys Rise-7w","Angel of Jubilation-4w","Arcane Melee-5u","Archwing Dragon-4r","Burn at the Stake-5r","Captain of the Mists-3u",
                        "Cathars Crusade-5w", "Cavern of Souls-0c","Champion of Lambholt-3g","Conjurers Closet-5c","Dark Impostor-3b", "Deadeye Navigator-6u", "Demonic Rising-5b",
                        "Demonlord of Ashmouth-4b", "Descendants Path-3g","Desolate Lighthouse-0c","Devastation Tide-5u","Divine Deflection-1w","Dread Slaver-5b","Druids Repository-3g",
                        "Dual Casting-2r","Exquisite Blood-5b","Gallows at Willow Hill-3c", "Gloom Surgeon-2b","Harvester of Souls-6b","Herald of War-5w","Hound of Griselbrand-4r",
                        "Infinite Reflection-6u","Killing Wave-1b","Lone Revenant-5u","Lunar Mystic-4u","Moonsilver Spear-4c","Otherworld Atlas-4c","Reforge the Soul-5r","Restoration Angel-4w",
                        "Revenge of the Hunted-6g","Riders of Gavony-4w","Rite of Ruin-7r","Silverblade Paladin-3w","Slayers Stronghold-0c","Somberwald Sage-3g","Soul of the Harvest-6g",
                        "Spirit Away-7u","Stolen Goods-4u","Terminus-6w","Treacherous Pit Dweller-2b","Tyrant of Discord-7r","Ulvenwald Tracker-1g","Vexing Devil-1r","Wild Defiance-3g",
                        "Wolfir Silverheart-5g","Zealous Conscripts-5r"};
    static String[] uncommons = {"Aggravate-5r","Angels Tomb-3c","Angelic Armaments-3c", "Appetite for Brains-1b","Archangel-7w","Banishing Stroke-6w","Barter in Blood-4b","Blessings of Nature-5g",
                        "Blood Artist-2b", "Bower Passage-2g","Builders Blessing-4w","Commanders Authority-5w","Corpse Traders-4b","Defy Death-5w","Demonic Taskmaster-3b","Devout Chaplain-3w",
                        "Druids Familiar-4g","Eaten by Spiders-3g","Emancipation Angel-3w","Evernight Shade-4b","Falkenrath Exterminator-3r","Favorable Winds-2u","Fettergeist-3u",
                        "Gang of Devils-6r","Ghostly Touch-2u","Gloomwidow-3g","Goldnight Commander-4w","Goldnight Redeemer-6w","Haunted Guardian-2c","Havengul Vampire-4r","Holy Justiciar-4w","Homicidal Seclusion-5b",
                        "Howlgeist-6g","Human Frailty-1b","Into the Void-4u","Kessig Malcontents-3r","Latch Seeker-3u","Lightning Mauler-2r","Lightning Prowess-3r","Maalfeld Twins-6b",
                        "Marrow Bats-5b","Mass Appeal-3u","Nearheath Pilgrim-2w","Nephalia Smuggler-1u","Rain of Thorns-6g","Rush of Blood-3r","Second Guess-2u","Stern Mentor-4u",
                        "Stonewright-1r","Tandem Lookout-3u","Thunderous Wrath-6r","Tormentors Trident-2c","Triumph of Cruelty-3b","Triumph of Ferocity-3g","Vanishment-5u","Vessel of Endless Rest-3c",
                        "Vigilante Justice-4r","Vorstclaw-6g","Wolfir Avenger-3g","Yew Spirit-5g"};
    static String[] commons = {"Abundant Growth-1g","Alchemists Apprentice-2b","Amass the Components-4b","Angels Mercy-4w","Angelic Wall-2w","Banners Raised-1r","Battle Hymn-2r","Bladed Bracers-1c",
                        "Bloodflow Connoisseur-3b","Bone Splinters-1b","Borderland Ranger-3g","Butcher Ghoul-2b","Call to Serve-2w","Cathedral Sanctifier-1w","Cloudshift-1w","Crippling Chill-3u",
                        "Crypt Creeper-2b","Cursebreak-2w","Dangerous Wager-2r","Death Wind-1b","Defang-2w","Demolish-4r","Diregraf Escort-1g","Dreadwaters-4u","Driver of the Dead-4b",
                        "Elgaud Shieldmate-4u","Essence Harvest-3b","Farbog Explorer-3w","Fervent Cathar-3r","Fleeting Distraction-1u","Flowering Lumberknot-4g","Galvanic Alchemist-3u",
                        "Geist Snatch-4u","Geist Trappers-5g","Ghostform-2u","Ghostly Flicker-3u","Ghoulflesh-1b","Grave Exchange-6b","Grounded-2g","Gryff Vanguard-5u","Guise of Fire-1r",
                        "Hanweir Lancer-3r","Havengul Skaab-6u","Heirs of Stromkirk-4r","Hunted Ghoul-1b","Joint Assault-1g","Kruin Striker-2r","Lair Delve-3g","Leap of Faith-3w","Mad Prophet-4r",
                        "Malicious Intent-2r","Mental Agony-4b","Midnight Duelist-1w","Midvast Protector-4w","Mist Raven-4u","Moonlight Geist-3w","Moorland Inquisitor-2w","Narstad Scrapper-5c",
                        "Natural End-3g","Necrobite-3b","Nettle Swine-4g","Nightshade Peddler-2g","Outwit-1u","Pathbreaker Wurm-6g","Peel from Reality-2u","Pillar of Flame-1r","Polluted Dead-5b",
                        "Predators Gambit-3b","Raging Poltergeist-4r","Renegade Demon-5b","Righteous Blow-1w","Riot Ringslinger-3r","Rotcrown Ghoul-5u","Scalding Devil-2r","Scrapskin Drake-3u",
                        "Scroll of Avacyn-1c","Scroll of Griselbrand-1c","Searchlight Geist-3b","Seraph of Dawn-4w","Seraph Sanctuary-0c","Sheltering Word-2g","Snare the Skies-1g",
                        "Somberwald Vigilante-1r","Soulcage Fiend-3b","Spectral Gateguards-5w","Spectral Prison-2u","Terrifying Presence-2g","Thatcher Revolt-3r","Thraben Valiant-2w",
                        "Thunderbolt-2r","Timberland Guide-2g","Trusted Forcemage-3g","Uncanny Speed-2r","Undead Executioner-4b","Unhallowed Pact-3b","Vanguards Shield-2c",
                        "Voice of the Provinces-6w","Wandering Wolf-2g","Wildwood Geist-5g","Wingcrafter-1u","Zealous Strike-2w"};
    
    public AvacynList()
    {
        pack = new ArrayList<Card>();
        sPack = new ArrayList<String>();
        makePack();
    }
    private void makePack()
    {
        //pick 8 commons
        for(int x = 0;x<10;x++)
        {
            sPack.add(commons[((int)(Math.random()*commons.length))]);
        }
        //pick 3 uncommons
        for(int x = 0;x<3;x++)
        {
            sPack.add(uncommons[((int)(Math.random()*uncommons.length))]);
        }
        //choose whether its a rare or mythic. 1/8 chance of getting a mythic.
        if(((int)(Math.random()*8)+1)==8)
        {
            //choose a mythic or\/
            sPack.add(mythics[((int)(Math.random()*mythics.length))]);
        }
        else
        {
            //choose a rare
            sPack.add(rares[((int)(Math.random()*rares.length))]);
        }
        //transform words into cards
        translate();
    }
    
    //makes the words into panels
    private void translate()
    {
        for(int x = 0;x<14;x++)
        {
            pack.add(new Card(sPack.get(x)));
        }
            
    }
    public ArrayList<Card> getPack()
    {
        return pack;
        
    }
    public void printCards()
    { 
        for(String s:sPack)
            System.out.println(s);
    }
}
