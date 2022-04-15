package com.example.customvalidation;

import com.example.customvalidation.validator.StringList;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Data
@ToString
public class SearchRequest {
    @Size(min=1, max=2)
    @StringList(maxChars = 11)
    private List<String> terms;
}
