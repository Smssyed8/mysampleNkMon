package com.mindfulqatar.jobportal.mapper;

import com.mindfulqatar.jobportal.dto.AdvertisementDTO;
import com.mindfulqatar.jobportal.dto.SearchAdvertisementsDTO;
import com.mindfulqatar.jobportal.entities.Advertisement;

import static com.mindfulqatar.jobportal.constants.Constant.ADVERTISEMENT_IMAGES_ROOT_FOLDER_PATH;
import static com.mindfulqatar.jobportal.constants.Constant.IMAGES_ROOT_FOLDER_PATH;

public class AdvertisementMapper {

	public static Advertisement toAdvertisement(SearchAdvertisementsDTO advertisementDTO) {
		Advertisement advertisement = new Advertisement();

		if (advertisementDTO.getId() != null) {
			advertisement.setId(advertisementDTO.getId());
		}

		if (advertisementDTO.getTitle() != null) {
			advertisement.setTitle(advertisementDTO.getTitle());
		}

		if (advertisementDTO.getPaymentDone() != null) {
			advertisement.setPaymentDone(advertisementDTO.getPaymentDone());
		}

		if (advertisementDTO.getShow() != null) {
			advertisement.setShow(advertisementDTO.getShow());
		}

		return advertisement;
	}

	public static Advertisement toAdvertisement(AdvertisementDTO advertisementDTO) {
		Advertisement advertisement = new Advertisement();

		if (advertisementDTO.getId() != null) {
			advertisement.setId(advertisementDTO.getId());
			advertisement.setImagePath(IMAGES_ROOT_FOLDER_PATH + ADVERTISEMENT_IMAGES_ROOT_FOLDER_PATH
					+ "advertisement_image_" + advertisementDTO.getId().toString() + ".png");
		}

		advertisement.setTitle(advertisementDTO.getTitle());
		advertisement.setText(advertisementDTO.getText());
		advertisement.setLink(advertisementDTO.getLink());
		advertisement.setButtonText(advertisementDTO.getButtonText());
		advertisement.setPaymentDone(advertisementDTO.getPaymentDone());
		advertisement.setShow(advertisementDTO.getShow());
		advertisement.setPrice(advertisementDTO.getPrice());

		return advertisement;
	}
}
