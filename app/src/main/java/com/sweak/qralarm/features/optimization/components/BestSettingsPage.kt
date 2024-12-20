package com.sweak.qralarm.features.optimization.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import com.sweak.qralarm.R
import com.sweak.qralarm.core.designsystem.icon.QRAlarmIcons
import com.sweak.qralarm.core.designsystem.theme.space

@Composable
fun BestSettingsPage(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.ensure_the_best_settings_possible),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(
                    start = MaterialTheme.space.medium,
                    end = MaterialTheme.space.medium,
                    bottom = MaterialTheme.space.xSmall
                )
        )

        Text(
            text = stringResource(R.string.ensure_the_best_settings_possible_description),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(
                start = MaterialTheme.space.medium,
                end = MaterialTheme.space.medium,
                bottom = MaterialTheme.space.xSmall
            )
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.space.xSmall),
            modifier = Modifier
                .padding(
                    start = MaterialTheme.space.medium,
                    end = MaterialTheme.space.medium,
                    bottom = MaterialTheme.space.medium
                )
        ) {
            Row {
                Text(
                    text = "•",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = MaterialTheme.space.xSmall)
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(stringResource(R.string.display_on_lock_screen))
                        }
                        append(" - ")
                        append(stringResource(R.string.display_on_lock_screen_description))
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Row {
                Text(
                    text = "•",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = MaterialTheme.space.xSmall)
                )

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(stringResource(R.string.autostart))
                        }
                        append(" - ")
                        append(stringResource(R.string.autostart_description))
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        ElevatedCard(
            onClick = onClick,
            colors = CardDefaults.elevatedCardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = MaterialTheme.space.xSmall
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = MaterialTheme.space.medium,
                    end = MaterialTheme.space.medium,
                    bottom = MaterialTheme.space.large
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = MaterialTheme.space.medium)
            ) {
                Spacer(modifier = Modifier.width(MaterialTheme.space.medium))

                Icon(
                    imageVector = QRAlarmIcons.SpecialAppSettings,
                    contentDescription = stringResource(
                        R.string.content_description_special_app_settings_icon
                    ),
                    modifier = Modifier.size(size = MaterialTheme.space.xLarge)
                )

                Text(
                    text = stringResource(R.string.click_to_go_to_app_settings),
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier
                        .padding(horizontal = MaterialTheme.space.medium)
                        .weight(1f)
                )

                Icon(
                    imageVector = QRAlarmIcons.ForwardArrow,
                    contentDescription = stringResource(
                        R.string.content_description_forward_arrow_icon
                    ),
                    modifier = Modifier.size(size = MaterialTheme.space.mediumLarge)
                )

                Spacer(modifier = Modifier.width(MaterialTheme.space.smallMedium))
            }
        }
    }
}