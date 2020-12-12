package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;
import subway.view.InputView;

import static subway.view.OutputView.askMessage;
import static subway.view.OutputView.warnMessage;

public class StationService {
    private final String STATION_NAME_LENGTH_WARN = "역 이름은 2글자 이상이어야 합니다.\n";
    private static final String ASK_STATION_NAME_MESSAGE = "등록할 역 이름을 입력하세요.\n";

    public boolean addStation(InputView inputView) {
        askMessage(ASK_STATION_NAME_MESSAGE);
        String stationName = inputView.inputStationName();
        if (stationName.length() < 2) {
            warnMessage(STATION_NAME_LENGTH_WARN);
            return false;
        }
        return StationRepository.addStation(new Station(stationName));
    }
}
