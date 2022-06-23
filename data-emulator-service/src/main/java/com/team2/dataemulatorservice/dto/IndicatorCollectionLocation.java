package com.team2.dataemulatorservice.dto;

import com.team2.dataemulatorservice.model.Building;
import com.team2.dataemulatorservice.util.RandomWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IndicatorCollectionLocation {

    private String buildingVerboseAddress;

    private String buildingOwnerName;

    private String roomName;

    public static List<IndicatorCollectionLocation> randomOf(List<Building> buildings, Integer datasetSize) {
        return IntStream.range(0, datasetSize).boxed()
                .map(i -> {
                    int randomBuildingId = RandomWrapper.getRandom().nextInt(buildings.size());
                    Building building = buildings.get(randomBuildingId);

                    int randomRoomId = RandomWrapper.getRandom().nextInt(building.getRooms().size());

                    return new IndicatorCollectionLocation(
                            building.getBuildingVerboseAddress(),
                            building.getBuildingOwner().getPersonName(),
                            building.getRooms().get(randomRoomId).getRoomName()
                    );
                }).collect(Collectors.toList());

    }
}
