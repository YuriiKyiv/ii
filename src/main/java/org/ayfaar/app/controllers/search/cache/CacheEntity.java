package org.ayfaar.app.controllers.search.cache;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.ayfaar.app.model.UID;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name= "cache")
public class CacheEntity {
    @Id
    @Column(name = "uid")
    private String uri;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", insertable = false, updatable = false)
    private UID uid;

    @Column(name = "content", columnDefinition = "TEXT")
    private String jsonContent;

    public CacheEntity(UID uid, String jsonContent) {
        this.uri = uid.getUri();
        this.uid = uid;
        this.jsonContent = jsonContent;
    }
}
