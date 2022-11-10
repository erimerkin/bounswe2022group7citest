package com.group7.artshare.controller;

import com.group7.artshare.entity.ArtItem;
import com.group7.artshare.entity.OnlineGallery;
import com.group7.artshare.entity.PhysicalExhibition;
import com.group7.artshare.repository.ArtItemRepository;
import com.group7.artshare.repository.OnlineGalleryRepository;
import com.group7.artshare.repository.PhysicalExhibitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("event2")
public class EventControllerJava {
    @Autowired
    PhysicalExhibitionRepository physicalExhibitionRepository;

    @Autowired
    ArtItemRepository artItemRepository;

    @Autowired
    OnlineGalleryRepository onlineGalleryRepository;


    @PostMapping(value = "create-online-gallery")
    public OnlineGallery createOnlineGallery(@RequestBody OnlineGallery onlineGallery){
        OnlineGallery newOnlineGallery = new OnlineGallery();
        newOnlineGallery.setCreator(onlineGallery.getCreator());
        newOnlineGallery.setCollaborators(onlineGallery.getCollaborators());
        newOnlineGallery.setEventInfo(onlineGallery.getEventInfo());
        newOnlineGallery.setPlatform(newOnlineGallery.getPlatform());
        newOnlineGallery.setArtItems(onlineGallery.getArtItems());
        newOnlineGallery.setExternalUrl(onlineGallery.getExternalUrl());
        return onlineGalleryRepository.save(newOnlineGallery);
    }


    @PostMapping(value = "create-physical-exhibition")
    public PhysicalExhibition createOnlineGallery(@RequestBody PhysicalExhibition physicalExhibition){
        PhysicalExhibition newPhysicalExhibition = new PhysicalExhibition();
        //newPhysicalExhibition.setCreator(physicalExhibition.getCreator());
        //newPhysicalExhibition.setLocation(physicalExhibition.getLocation());
        newPhysicalExhibition.setRules(physicalExhibition.getRules());
        //newPhysicalExhibition.setEventInfo(physicalExhibition.getEventInfo());
        //newPhysicalExhibition.setCollaborators(physicalExhibition.getCollaborators());
        return physicalExhibitionRepository.save(newPhysicalExhibition);
    }

    @PostMapping("create-art-item")
    public ArtItem createArtItem(@RequestBody ArtItem artItemDTO){
        ArtItem artItem = new ArtItem();
        artItem.setArtItemInfo(artItemDTO.getArtItemInfo());
        artItem.setCreator(artItemDTO.getCreator());
        artItem.setAuction(artItemDTO.getAuction());
        artItem.setLastPrice(artItemDTO.getLastPrice());
        artItem.setOnAuction(artItemDTO.getOnAuction());
        artItem.setOwner(artItemDTO.getOwner());
        return artItemRepository.save(artItem);
    }

}

