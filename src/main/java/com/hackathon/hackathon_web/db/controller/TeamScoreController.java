package com.hackathon.hackathon_web.db.controller;

import com.hackathon.hackathon_web.db.entity.TeamScore;
import com.hackathon.hackathon_web.db.service.TeamScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team_score")
public class TeamScoreController {
    @Autowired
    private TeamScoreService teamScoreService;

    @PostMapping("/add_score")
    public void addScore(@RequestBody TeamScore teamScore) {
        // Получаем существующую запись оценок для данной команды (если она существует)
        TeamScore existingTeamScore = teamScoreService.getTeamById(teamScore.getIdTeam());

        // Если запись оценок для данной команды уже существует, обновляем ее
        if (existingTeamScore != null) {
            // Обновляем суммарные оценки и количество проголосовавших
            long updatedDesignScore = existingTeamScore.getScoreDesign() + teamScore.getScoreDesign();
            long updatedUsabilityScore = existingTeamScore.getScoreUsability() + teamScore.getScoreUsability();
            long updatedImplementationScore = existingTeamScore.getScoreImplementation() + teamScore.getScoreImplementation();
            long updatedGeneralScore = existingTeamScore.getScoreGeneral() + teamScore.getScoreGeneral();
            long updatedCountNumber = existingTeamScore.getCountNumber() + 1;

            // Обновляем запись оценок
            existingTeamScore.setScoreDesign(updatedDesignScore);
            existingTeamScore.setScoreUsability(updatedUsabilityScore);
            existingTeamScore.setScoreImplementation(updatedImplementationScore);
            existingTeamScore.setScoreGeneral(updatedGeneralScore);
            existingTeamScore.setCountNumber(updatedCountNumber);

            // Сохраняем обновленную запись оценок
            teamScoreService.save(existingTeamScore);
        } else {
            // Если запись оценок для данной команды не существует, создаем новую
            teamScore.setCountNumber(1L); // Устанавливаем количество проголосовавших на 1, так как это первый голос
            teamScoreService.save(teamScore); // Сохраняем новую запись оценок
        }
    }

    @GetMapping("/get/{id}")
    public TeamScore getTeamById(@PathVariable long id) {
        return teamScoreService.getTeamById(id);
    }


}
