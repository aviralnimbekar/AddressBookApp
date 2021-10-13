/**
 * Create and maintains response data in object.
 * class contains a message field and a general field for any type of data
 *
 * @author Aviral Nimbekar
 * @version 0.0.1
 * @since 13/10/2021
 */

package com.bridgelabz.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {

    public String message;
    public Object data;
}
