package org.ysfyrdmcl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.ysfyrdmcl.dto.request.CompetitionRequestDto;
import org.ysfyrdmcl.repository.entity.Competition;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompetitionMapper {
    ICompetitionMapper INSTANCE = Mappers.getMapper(ICompetitionMapper.class);

    /**
     * farklı değişken isimlerini maplemek için kullanıldı.
     * örnek olsun diye yazdım.
     * @param dto
     * @return
     */
    @Mappings({
            @Mapping(source = "creatorid", target = "creatorid"),
            @Mapping(source = "competitiontitle", target = "competitiontitle")


    })
    Competition toCompetition(CompetitionRequestDto dto);
}
